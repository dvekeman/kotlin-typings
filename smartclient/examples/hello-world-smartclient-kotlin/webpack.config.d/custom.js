// See build/webpack.config.js for the resulting webpack config
// The `config` object starts from a template and can be modified in this custom configuration
// ```
// var config =
//   {
//     ... some defaults ...
//   }
//
// module.exports = config;
//
// ... the customization
//
// ```
config.output.library = 'hello';
config.output.libraryTarget = 'umd';
config.devtool = 'source-map';