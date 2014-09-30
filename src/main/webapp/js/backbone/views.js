var app = app || {};
app.loadViews = function ($) {
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
			this.listenTo(app.movies, 'all', this.render);
		},
		render: function() {
			this.addAll();
		},
		addAll: function() {
			this.$el.html('');
			app.movies.each(this.addOne, this);
		},
		addOne: function (movie) {
			var view = new app.MovieRateView({ model: movie });
			this.$el.append(view.render().el);
		}
	});
};
