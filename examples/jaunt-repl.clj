#!/bin/sh

#_[
   eval "exec $(inlein --sh-cmd "$0" "$@")"
#_ 0]

;; Instead of using Clojure, we can use the Jaunt-lang fork and make a repl out
;; of it. Remember that most dependencies depend on Clojure, and so you'll
;; probably have to explicitly exclude org.clojure/clojure for dependencies you
;; add in.

'{:dependencies [[org.jaunt-lang/jaunt "1.9.0-RC4"]
                 [reply "0.3.7" :exclusions [net.cgrand/parsley
                                             org.clojure/clojure]]
                 [net.cgrand/parsley "0.9.3" :exclusions [org.clojure/clojure]]]
  :jvm-opts ["-XX:+TieredCompilation" "-XX:TieredStopAtLevel=1" "-Dfile.encoding=UTF-8"]}

(reply.ReplyMain/main (into-array String ["--standalone"]))


