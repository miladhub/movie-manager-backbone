var app = app || {};
(function ($) {
	'use strict';
	app.MovieRateView = Backbone.View.extend({
		template: _.template( $("#rate-template").html() ),
		render: function() {
			this.$el.html(this.template(this.model.toJSON()));
			return this;
		},
	});
	app.DashboardView = Backbone.View.extend({
		el: '#rates',
		initialize: function() {
			app.movies.add(new Movie({title: 'a scanner darkly', author: 'ridley scott', rates: 100}));
			app.movies.add(new Movie({title: 'blade runner', author: 'ridley scott', rates: 200}));
		},
		render: function() {
			this.addAll();
		},
		addAll: function() {
			this.$el.html('');
			app.movies.each(this.addOne, this);
		},
		addOne: function (movie) {
			var view = new app.MovieView({ model: movie });
			this.$el.append(view.render().el);
		}
	});
)(jQuery);
