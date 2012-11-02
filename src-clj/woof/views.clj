(ns woof.views
  (:require
    [hiccup
      [page :refer [html5]]
      [element :refer [javascript-tag]]
      [page :refer [include-js]]
      [page :refer [include-css]]]))

(defn- include-clojurescript [path init]
  (list
    (javascript-tag "var CLOSURE_NO_DEPS = true;")
    (include-js path)
    (javascript-tag init)))

(defn index-page []
  (html5
    [:head
     [:title "Woof!"]
     (include-css "http://fonts.googleapis.com/css?family=Cedarville+Cursive")]
    [:body
     [:canvas#img-can {:width 592 :height 301}]
     [:div [:textarea#text-in {:style "width: 300px; height: 100px"}]]
     [:div [:button#draw "Open as image."]]
     [:div#fontload {:style "font-family: 'Cedarville Cursive', cursive; color: #FFFFFF;"} "a" ]]

    (include-clojurescript
      "js/main.js"
      "woof.main.main()")
    (javascript-tag "woof.repl.connect()")))
