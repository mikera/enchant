# Enchant
Clojure integration for the Magic language 

## Overview

Magic is an experimental JVM Lisp (see: https://github.com/mikera/magic)

Enchant is a lightweight library tool that enables you to run Magic from a Clojure-based REPL, making use of the excellent nREPL tooling (https://github.com/clojure/tools.nrepl)

Rationale for this approach:
- nREPL already has a flexible, well-designed approach to handle interative Lisp programming
- Piggy-backing on nREPL means that Magic gets automatic support from nREPL clients (tested with Leiningen, Counterclockwise but should work with any nREPL clients)
- You can make use of existing nREPL middleware, if desired

Magic does not need Enchant (it has its own simple built-in REPL, and can be run directly from the commend line). However if you use Clojure-based development tools, it offers an easy way to get started with Magic.

## Usage as leiningen plugin

The simplest way to use enchant is as a leiningen plugin. It can be launched at the command line as follows:

```
lein magic
```

This gets you to a **Clojure** REPL prompt. Type `magic` to switch to the magic REPL

Type `exit` to return to Clojure-land


