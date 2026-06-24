(defproject io.github.kylc/minitui "0.1.0"
  :description "Create terminal user interfaces in jank"
  :url "https://github.com/kylc/minitui"
  :license {:name "MPL 2.0"
            :url  "https://www.mozilla.org/en-US/MPL/2.0/"}
  :dependencies [[io.github.kylc/ftxui-sys "7.0.0"]]
  :plugins [[org.jank-lang/lein-jank "2026.06-1"]]
  :middleware [leiningen.jank/middleware]
  :profiles {:base    {:jank {:target-dir         "target/debug"
                              :optimization-level 0}}
             :release {:jank {:target-dir         "target/release"
                              :optimization-level 3
                              :runtime            :static}}
             :demo    {:source-paths ["examples"]
                       :main         demo}}
  :source-paths ["src"])
