const webpack = require('webpack');
const path = require('path');
// const MiniCssExtractPlugin = require("mini-css-extract-plugin");
// const UglifyJsPlugin = require("uglifyjs-webpack-plugin");

module.exports = {
  entry: './ui/entry.js',
  output: { path: path.resolve(__dirname, 'public/compiled'), filename: 'bundle.js' },
  module: {
    rules: [
      {
        test: /\.jsx?$/,
        include: /ui/,

        use: [
          {
            loader: 'babel-loader',
            options: {
              presets: [
                '@babel/preset-react',
                '@babel/preset-env'
              ],
              plugins: [
                ["@babel/plugin-proposal-class-properties", {
                  "loose": true
                }]
              ],
            }
          }
        ]
      },
      {
        test: /\.scss$/,
        use: [
          'style-loader', 'css-loader', 'sass-loader'
        ]
      }
    ]
  },
  // plugins: [
  //   new MiniCssExtractPlugin({ filename: "styles.css" })
  // ],
  // optimization: {
  //   minimizer: [
  //     new UglifyJsPlugin({
  //       uglifyOptions: {
  //       cache: true,
  //       paralell: true
  //     }})
  //   ]
  // }
};