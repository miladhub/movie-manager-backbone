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
		model: app.Movie
	});
	app.movies = new Movies();
})();
