const path = require('path');

module.exports = {
    mode: 'development',
    devtool: 'source-map',
    entry: path.resolve(__dirname, 'build/classes/kotlin/main/kotlin-single-js-file-lib.js'),
    resolve: {
        "modules": [
            path.resolve(__dirname, 'build/js'),
            "node_modules"
        ]
    },
    output: {
        filename: "kotlin-single-js-file-lib.js",
        libraryTarget: "umd",
        path: path.resolve(__dirname, 'build/webpack'),
    }

};
