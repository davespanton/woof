(ns woof.main
  [:require
   [domina :as dom]
   [domina.events :as domev]
   [clojure.string :as string]])

(def img (new js/Image))

(def ctx (.getContext (dom/by-id "img-can") "2d"))

(defn draw-image []
  (.drawImage ctx img 0 0))

(defn draw-text-lines [lines x y width]
  (if (> (count lines) 0)
    (do
      (.fillText ctx (first lines) x y width)
      (recur (rest lines) (+ x 3) (+ y 35) (- width 3)))))

(defn image-onload []
  (do
    (draw-image)
    (js/setTimeout #(dom/detach! (dom/by-id "fontload")) 100)))

(defn download []
  (.open js/window (.toDataURL (dom/by-id "img-can")) "toDataURL() image" "width=592, height=301"))

(defn ^:export draw-text [evt]
  (do
    (draw-image)
    (set! (.-font ctx) "30px Cedarville Cursive")
    (draw-text-lines (string/split-lines (dom/value (dom/by-id "text-in"))) 175 185 200)))

(defn ^:export main []
  (do
    (set! (.-onload img) image-onload)
    (set! (.-src img) "img/blank-dog.png")
    (domev/listen! (dom/by-id "draw") :click download)
    (domev/listen! (dom/by-id "text-in") :keyup draw-text)
    (domev/listen! (dom/by-id "text-in") :change draw-text)))
