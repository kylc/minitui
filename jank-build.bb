(require '[babashka.fs :as fs])

(let [src-dir (:src-dir *input*)]
  (println (str "jank-build::include-dir=" (fs/path src-dir "src"))))
