(ns app.response
  (:require
   [app.request :as r]
   [hiccup2.core :as h]))

(defn render [content & {:keys [status content-type] :or {content-type "text/html"}}]
  (println
   (str
    (r/env :SERVER_PROTOCOL) (or status "200") "OK\n"
    "Content-type:" (or content-type "text/html") "\n\n"
    (h/html content))))
