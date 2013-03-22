# A Silly Webapp

To learn a little ClojureScript.

This is based off the example web application from [lein-cljsbuild][1].

See it running on Heroku: http://fathomless-sands-5175.herokuapp.com/

## Running it locally

Set up and start the server like this:

    $ lein deps
    $ lein cljsbuild once
    $ lein ring server-headless 3000

Now, point your web browser at `http://localhost:3000`, and see the web app in action!

[1]: https://github.com/emezeske/lein-cljsbuild
