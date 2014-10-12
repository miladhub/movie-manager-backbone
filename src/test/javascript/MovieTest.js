describe("Movie manager dashboard", function() {
	beforeEach(function() {
		jasmine.getFixtures().fixturesPath = '/src/test/fixtures'
		loadFixtures('mock-templates.html');
		$('body').append('<div id="rates">Loading...</div>');
		app.loadModels();
		app.loadViews(jQuery);
	});

	afterEach(function() {
		$('#rates').remove();
	});

	it("renders movies as they are added to the movies collection", function() {
		new app.DashboardView();
		expect($("#rates").html()).not.toContain('a scanner darkly');
		app.movies.add(new app.Movie({title: 'a scanner darkly', author: 'ridley scott', stars: 100}));
		expect($("#rates").html()).toContain('a scanner darkly');
	});
});