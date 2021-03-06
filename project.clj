(defproject biva-clojure-test "0.1.0-SNAPSHOT"
  :description "REST service for documents"
  :url "http://github.com/riosgabriel"
  :main bivatest.main

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring-core "1.2.1"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [compojure "1.1.6"]
                 [cheshire "5.3.1"]
                 [ring/ring-json "0.2.0"]
                 [korma "0.4.0"]
                 [org.postgresql/postgresql "9.2-1002-jdbc4"]
                 [environ "1.0.2"]
                 [org.clojure/data.json "0.2.6"]]

  :plugins [[lein-ring "0.8.10"]
            [ragtime/ragtime.lein "0.3.6"]
            [lein-environ "1.0.2"]]
  :profiles { :dev
               {:env {:database-url "//localhost:5432/biva-db"
                      :database-user "gabriel"
                      :database-password "rios"}
                :dependencies [[javax.servlet/servlet-api "2.5"]
                               [ring-mock "0.1.5"]]}
              :prod
                {:env {:database-url "//localhost:5432/biva-db"
                       :database-user "gabriel"
                       :database-password "rios"}}
             }
  :ring {:handler bivatest.api.handler/app}
  )
