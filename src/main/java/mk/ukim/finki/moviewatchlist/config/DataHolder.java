package mk.ukim.finki.moviewatchlist.config;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.service.MovieService;
import mk.ukim.finki.moviewatchlist.service.ReviewService;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


@Component
@Getter
@RequiredArgsConstructor
public class DataHolder {
  private final MovieService movieService;
  private final ReviewService reviewService;

  @PostConstruct
  public void initData() throws IOException {

    List<Movie> movies = new ArrayList<>();

    // SPARQL query to retrieve movie names
    String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX dbo: <http://dbpedia.org/ontology/>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
            "PREFIX dbr: <http://dbpedia.org/resource/>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
            "SELECT ?movie ?description ?image ?genre WHERE { " +
            "?movie rdf:type dbo:Film . " +
            "?movie rdfs:comment ?description . " +
            "?movie dbo:releaseDate ?date . " +
            "OPTIONAL { ?movie dbo:thumbnail ?image . } " +
            "OPTIONAL { ?movie dbo:genre ?genreResource . ?genreResource rdfs:label ?genre . FILTER (LANG(?genre) = 'en') } " +
            "FILTER (LANG(?description) = 'en' && ?date > '2015-01-01'^^xsd:date) " +
            "} " +
            "GROUP BY ?movie ?description ?image ?genre " +
            "LIMIT 100";


    // DBpedia endpoint
    String dbpediaEndpoint = "http://dbpedia.org/sparql";

    // Creating the query object
    Query query = QueryFactory.create(sparqlQuery);

    try (QueryExecution queryExec = QueryExecutionFactory.sparqlService(dbpediaEndpoint, query)) {
      // Executing the query and obtaining the results
      ResultSet resultSet = queryExec.execSelect();

      // Iterating over the results and printing the movie name and description
      while (resultSet.hasNext()) {
        QuerySolution solution = resultSet.nextSolution();
        Resource movieResource = solution.getResource("movie");
        String movieName = movieResource.getLocalName();

        Literal descriptionLiteral = solution.getLiteral("description");
        String movieDescription = descriptionLiteral.getString();

        String imageUrl = getWikipediaImage(movieName);

        Literal genreLiteral = solution.getLiteral("genre");
        String genreString = (genreLiteral != null) ? genreLiteral.getString() : null;
        Genre genre = mapGenre(genreString);

        if (imageUrl != null) {
          Movie movie = new Movie(movieName, movieDescription, genre, imageUrl);
          movies.add(movie);
        }

        System.out.println("Movie: " + movieName);
        System.out.println("Description: " + movieDescription);
        System.out.println("Image URL: " + imageUrl);
        System.out.println("Genre: " + genre.toString());
        System.out.println();
      }
    }

    System.out.println("size of the fina list is : " + movies.size());
    System.out.println("and the contents are : " + movies.toString());

    movies.forEach(movieService::save);
  }

  private static String getWikipediaImage(String movieName) {
    String wikipediaUrl = "https://en.wikipedia.org/wiki/" + movieName.replace(" ", "_");

    try {
      Document doc = Jsoup.connect(wikipediaUrl).get();
      Elements infoboxes = doc.select(".infobox img");

      if (!infoboxes.isEmpty()) {
        Element infobox = infoboxes.first();
        String imageUrl = infobox.absUrl("src");

        return imageUrl;
      }
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

    return null;
  }

  private static Genre mapGenre(String genreString) {
    if (genreString != null) {
      String normalizedGenre = genreString.toUpperCase().replaceAll("\\s+", "_");
      try {
        return Genre.valueOf(normalizedGenre);
      } catch (IllegalArgumentException e) {
        // Genre mapping not found, return OTHER
      }
    }
    return Genre.OTHER;
  }
}


// TODO: 7/1/2023 Movie name and description
// SELECT ?movie ?description WHERE {
//        ?movie rdf:type dbo:Film .
//        ?movie dbo:abstract ?description .
//        FILTER (LANG(?description) = 'en')
//        } LIMIT 1000

//SELECT ?movie ?description ?image WHERE {
//        ?movie rdf:type dbo:Film .
//        ?movie dbo:abstract ?description .
//        ?movie dbo:thumbnail ?image .
//        ?movie dbo:releaseDate ?date . FILTER (LANG(?description) = 'en' && ?date > '2020-01-01'^^xsd:date)
//        } LIMIT 1000
