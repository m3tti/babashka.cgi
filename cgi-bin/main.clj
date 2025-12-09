#!/usr/bin/env bb

(babashka.classpath/add-classpath "./cgi-bin/")
(require '[app.routes :as r])
(r/route)
