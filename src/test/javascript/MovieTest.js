describe("Movie manager dashboard", function() {
	beforeEach(function() {
		$('body').append('<div id="rates">Loading...</div>');
	});

	beforeEach(function() {
		app.MovieRateView = _.extend(app.MovieRateView, {
			template: _.template('<h1>hello</h1>')
		});
	});

	afterEach(function() {
		$('#rates').remove();
	});

	it("renders movies as they are added to the movies collection", function() {
		new app.DashboardView();
		expect($("#rates").length).toEqual(0);
		app.movies.add(new app.Movie({title: 'a scanner darkly', author: 'ridley scott', rates: 100}));
		expect($("#rates").length).toEqual(1);
	});
});