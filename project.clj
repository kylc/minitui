(defproject io.github.kylc/minitui "0.1.0-SNAPSHOT"
  :description "Create terminal user interfaces in jank"
  :url "https://github.com/kylc/minitui"
  :license {:name "MPL 2.0"
            :url  "https://www.mozilla.org/en-US/MPL/2.0/"}
  :dependencies [[io.github.kylc/ftxui-sys "7.0.0"]]
  :plugins [[org.jank-lang/lein-jank "0.7"]]
  :middleware [leiningen.jank/middleware]
  :profiles {:base    {:jank {:output-dir         "target/debug"
                              :optimization-level 0}}
             :demo    {:source-paths ["examples"]
                       :main         demo}
             :release {:jank {:output-dir         "target/release"
                              :optimization-level 2
                              :runtime            :static}}}
  :source-paths ["src"])
