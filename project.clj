(defproject cljsbuild-example-simple "0.2.9"
  :description "A simple example of how to use lein-cljsbuild"
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.0.4"]
                 [hiccup "1.0.0"]
                 [domina "1.0.1"]
                 [ring/ring-jetty-adapter "1.1.0"]]
  :dev-dependencies [[lein-ring "0.7.0"]
                     [com.cemerick/piggieback "0.0.2"]]
  :plugins [[lein-cljsbuild "0.2.9"]]
  :cljsbuild {
    :builds [{:source-path "src-cljs"
              :compiler {:output-to "resources/public/js/main.js"
                         :optimizations :whitespace
                         :pretty-print true}}]}
  :ring {:handler woof.routes/app}
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :min-lein-version "2.0.0")
