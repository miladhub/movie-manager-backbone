var app = app || {};
app.loadModels = function () {
	'use strict';
	app.Movie = Backbone.Model.extend({
		defaults: {
			title: '',
			author: '',
			stars: 0,
			year: 0
		}
	});
	var Movies = Backbone.Collection.extend({
		model: app.Movie,
		url: '/movie/rest/movies'
	});
	app.movies = new Movies();
	app.Category = Backbone.Model.extend({
		defauls: {
			name: ''
		}
	});
	var Categories = Backbone.Collection.extend({
		model: app.Category,
		url: '/movie/rest/categories'
	});
	app.categories = new Categories();
};
