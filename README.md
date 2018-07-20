# ![CF](http://i.imgur.com/7v5ASc8.png) Scrape Site for Album Covers

## Resources
* [jsoup Java HTML Parser](https://jsoup.org/)

## Feature Tasks
* Build a simple HTML page with a form with one text input.
* Configure your server to specially recognize requests made to `/search`
* Configure your server to parse query params
  * pick off `query` and `The Beatles` off `/search?query=The Beatles`
* Use the query to scrape an album art image off discogs.com
* Send back a special webpage that includes the album art URL in an `img` tag.

Sample discogs searches:

* <https://www.discogs.com/search/?q=thrice+vheissu&type=all>
* <https://www.discogs.com/Sufjan-Stevens-All-Delighted-People-EP/master/291315>

## Testing
* Write a unit test for your scraper to make sure it returns an image for
  music you know.
* Write a unit test for your scraper to make sure it returns the default
  album art placeholder for music discogs.com can't find.

## Documentation
Use `README.md` to provide a brief description of what your application does
and explain how it behaves when it can't find album art.

## Stretch Goals
* Cache search results in a database so you don't need to fetch and scrape
  the discogs.com website every time someone searches.
  * Save the query and the image result in a database to cache the search
  * Check the database for future searches to see if you've fetched the image
    already
* Download the images from discogs.com and save them to your own server so
  you're not hot-linking images.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
