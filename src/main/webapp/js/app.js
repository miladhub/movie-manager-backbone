var App = function() {
	'use strict';
	
	var app = {};
	
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
		url: 'rest/movies'
	});
	app.movies = new Movies();
	app.Category = Backbone.Model.extend({
		defaults: {
			name: ''
		}
	});
	var Categories = Backbone.Collection.extend({
		model: app.Category,
		url: 'rest/categories'
	});
	app.categories = new Categories();
	
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
	app.CategoryView = Backbone.View.extend({
		tagName: 'li',
		template: _.template( $("#sidebar-el-template").html() ),
		render: function() {
			this.$el.html(this.template(this.model.toJSON()));
			return this;
		},
		events: {
			"click" : "showElement"
		},
		showElement: function(e) {
			alert("clicked on " + this.model.get('name'));
			return false;
		}
	});
	app.SideBarView = Backbone.View.extend({
		el: '#sidebar',
		initialize: function() {
			this.listenTo(app.categories, 'all', this.render);
		},
		render: function() {
			this.addAll();
		},
		addAll: function() {
			this.$el.html('');
			app.categories.each(this.addOne, this);
		},
		addOne: function (category) {
			var view = new app.CategoryView({ model: category });
			this.$el.append(view.render().el);
		}
	});
	new app.DashboardView();
	new app.SideBarView();
	
	return app;
};