var app = app || {};
(function () {
	'use strict';
	app.Movie = Backbone.Model.extend({
		defaults: {
			title: '',
			author: '',
			rates: 0
		}
	});
	var Movies = Backbone.Collection.extend({
		model: app.Movie,
		localStorage: new Backbone.LocalStorage('movies-backbone')
	});
	app.movies = new Movies();
})();
