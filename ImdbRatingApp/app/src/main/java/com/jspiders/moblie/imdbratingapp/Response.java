package com.jspiders.moblie.imdbratingapp;

import java.util.List;

/**
 * Created by user on 09/07/2016.
 */
public class Response {
    /**
     * Search : [{"Title":"Batman: The Dark Knight Returns, Part 2","Year":"2013","imdbID":"tt2166834","Type":"movie","Poster":"http://ia.media-imdb.com/images/M/MV5BMTQ1Mjk1NTY2NV5BMl5BanBnXkFtZTgwMTA2MDEwNzE@._V1_SX300.jpg"},{"Title":"Batman: The Movie","Year":"1966","imdbID":"tt0060153","Type":"movie","Poster":"http://ia.media-imdb.com/images/M/MV5BMTkzODAyMjg2Ml5BMl5BanBnXkFtZTgwMzI4NzM1MjE@._V1_SX300.jpg"},{"Title":"Batman: Year One","Year":"2011","imdbID":"tt1672723","Type":"movie","Poster":"http://ia.media-imdb.com/images/M/MV5BMjE2MzMxNDQ1NF5BMl5BanBnXkFtZTcwNzE1NTI5Ng@@._V1_SX300.jpg"},{"Title":"Batman: Gotham Knight","Year":"2008","imdbID":"tt1117563","Type":"movie","Poster":"http://ia.media-imdb.com/images/M/MV5BMTQ1NjExODcyNl5BMl5BanBnXkFtZTcwMTk0MDc4MQ@@._V1_SX300.jpg"},{"Title":"Batman: Arkham City","Year":"2011","imdbID":"tt1568322","Type":"game","Poster":"http://ia.media-imdb.com/images/M/MV5BZDhjZTVkZGYtNWFmMC00MDU5LWIxZjEtNzQ4NjU1OTNlNTJlXkEyXkFqcGdeQXVyNTM3NzExMDQ@._V1_SX300.jpg"},{"Title":"Batman Beyond","Year":"1999\u20132001","imdbID":"tt0147746","Type":"series","Poster":"http://ia.media-imdb.com/images/M/MV5BMTA3MjkzNDM0OTBeQTJeQWpwZ15BbWU3MDk3ODM5MjE@._V1._CR1,0,208,299_SY132_CR1,0,89,132_AL_.jpg_V1_SX300.jpg"},{"Title":"Superman/Batman: Apocalypse","Year":"2010","imdbID":"tt1673430","Type":"movie","Poster":"http://ia.media-imdb.com/images/M/MV5BMTYzMDU0MjEwOF5BMl5BanBnXkFtZTcwOTA5ODc2Mw@@._V1_SX300.jpg"},{"Title":"Batman: Assault on Arkham","Year":"2014","imdbID":"tt3139086","Type":"movie","Poster":"http://ia.media-imdb.com/images/M/MV5BMTAxMDY2OTA2NzReQTJeQWpwZ15BbWU4MDg1NDk1MzIx._V1_SX300.jpg"},{"Title":"Batman Beyond: Return of the Joker","Year":"2000","imdbID":"tt0233298","Type":"movie","Poster":"http://ia.media-imdb.com/images/M/MV5BMTQ4MDQwMDUxNF5BMl5BanBnXkFtZTcwODY2NDEyMQ@@._V1_SX300.jpg"},{"Title":"Batman: Arkham Asylum","Year":"2009","imdbID":"tt1282022","Type":"game","Poster":"http://ia.media-imdb.com/images/M/MV5BMTUyMzMzMTU0MF5BMl5BanBnXkFtZTcwNDM3MTcxMw@@._V1_SX300.jpg"}]
     * totalResults : 309
     * Response : True
     */

    private String totalResults;
    private String Response;
    /**
     * Title : Batman: The Dark Knight Returns, Part 2
     * Year : 2013
     * imdbID : tt2166834
     * Type : movie
     * Poster : http://ia.media-imdb.com/images/M/MV5BMTQ1Mjk1NTY2NV5BMl5BanBnXkFtZTgwMTA2MDEwNzE@._V1_SX300.jpg
     */

    private List<Search> Search;

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String Response) {
        this.Response = Response;
    }

    public List<Search> getSearch() {
        return Search;
    }

    public void setSearch(List<Search> Search) {
        this.Search = Search;
    }

    public static class Search {
        private String Title;
        private String Year;
        private String imdbID;
        private String Type;
        private String Poster;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getYear() {
            return Year;
        }

        public void setYear(String Year) {
            this.Year = Year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getPoster() {
            return Poster;
        }

        public void setPoster(String Poster) {
            this.Poster = Poster;
        }
    }
}
