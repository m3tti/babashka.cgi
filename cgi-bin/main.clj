#!/usr/bin/env bb

(deps/add-deps '{:deps {org.clojars.askonomm/ruuter {:mvn/version "1.3.5"}}})
(babashka.classpath/add-classpath "./cgi-bin/")
(require '[app.main :as m])
(m/start)
