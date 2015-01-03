require.config({
    paths: {
        'jquery': 'assets/jquery-1.11.1.min',
        'underscore': 'assets/underscore-1.3.3.min',
        'backbone': 'assets/backbone-min-1.1.2',
        'bootstrap': 'assets/bootstrap.min'
    },
    shim: {
        'underscore': {
            exports: '_'
        },
        'backbone': {
            deps: ["underscore", "jquery"],
            exports: 'Backbone'
        },
        "bootstrap" : {
            deps :["jquery"]
        },
        'app': {
        	deps: ["underscore", "jquery", "backbone"],
        	exports: 'App'
        }
    }
});

require(["bootstrap"]);

require(["app"], function(App) {
	var app = new App();
	app.categories.fetch();
	app.movies.fetch();
});
