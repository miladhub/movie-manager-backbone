var app = app || {};
app.loadModels = function () {
	'use strict';
	app.Movie = Backbone.Model.extend({
		defaults: {
			title: '',
			author: '',
			rates: 0
		}
	});
	var Movies = Backbone.Collection.extend({
		model: app.Movie
	});
	app.Category = Backbone.Model.extend({
		defauls: {
			name: ''
		}
	});
	app.movies = new Movies();
};