# Create a single JS file from Kotlin including the Kotlin standard library and other dependencies.

In this example Webpack is used to package a KotlinJS project together with all its dependencies into a single JS file.

Most of the magic happens in `build.gradle`. But please also have a look at `package.json` and `webpack.config.js`.

Run `gradle build` in order to create the JS file in `build/webpack`.

`open index.html` in a Browser to see the result. Which in this case is "Hello World" ;-).

