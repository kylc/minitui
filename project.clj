(defproject io.github.kylc/minitui "0.3.0-SNAPSHOT"
  :description "Create terminal user interfaces in jank"
  :url "https://github.com/kylc/minitui"
  :license {:name "MPL 2.0"
            :url  "https://www.mozilla.org/en-US/MPL/2.0/"}
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :dependencies [[org.jank-lang.commons/ftxui-sys "2026.06-1"]]
  :plugins [[org.jank-lang/lein-jank "2026.07-3"]]
  :middleware [leiningen.jank/middleware]
  :profiles {:base {:jank {:target-dir         "target"
                           :optimization-level 3
                           :name               "minitui-demo"}}}
  :source-paths ["src" "examples"]
  :main minitui.demo)
