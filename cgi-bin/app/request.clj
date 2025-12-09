(ns app.request
  (:require
   [clojure.string :as str]
   [hiccup2.core :as h]
   [cheshire.core :as json]))

(defn env [keyword]
  (System/getenv (name keyword)))

(defn request-method []
  (env :REQUEST_METHOD))

(defn server-url []
  (let [host (env :SERVER_NAME)
        port (env :SERVER_PORT)
        path (env :PATH_INFO)]
    (str host ":" port path)))

(defn query-params []
  (let [query-string (env :QUERY_STRING)]
    (clojure.walk/keywordize-keys 
     (into {}
           (map #(str/split % #"=")
                (str/split query-string #"&"))))))

(defn read-post-body
  "reads the POST body from stdin"
  []
  (try (let [body (slurp *in*)
             parts (str/split body #"&")
             pairs (mapv #(str/split % #"=") parts)]
         (into {} pairs))
       (catch Exception e {})))

(defn build-request []
  {:uri (env :PATH_INFO)
   :request-method (keyword (str/lower-case (request-method)))})
