(ns app.response
  (:require [hiccup2.core :as h]))

(defn render [content & {:keys [content-type] :or {content-type "text/html"}}]
  (println (str "Content-type:" content-type "\n\n"))
  (println
   (str (h/html content))))
