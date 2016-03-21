## biva-clojure-test

# Prerequisites

You will need

- [Leiningen][] 2.0.0 or above.
- [PostgreSQL][] 9.2 or above.

[PostgreSQL]: http://www.postgresql.org/

[leiningen]: https://github.com/technomancy/leiningen

# Database
Scrips for the database are located in:

    resources/db/queries.sql

# Running

To start a web server for the application, run:

    lein deps
    lein ring server-headless