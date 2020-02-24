module.exports= {
    outputDir: "../src/main/resources/static",
    indexPath: "../static/index.html",
    devServer: {
        overlay: {
            warning:false,
            errors: true
        },
        proxy: {
            '/api': {
                target: "http://localhost:5080",
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    },
    chainWebpack: config => {
        const svgRule = config.module.rule("svg");
        svgRule.uses.clear();
        svgRule.use("vue-svg-loader").loader("vue-svg-loader");
    }
};