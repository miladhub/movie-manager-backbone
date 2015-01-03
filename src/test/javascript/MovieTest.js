describe("Movie manager dashboard", function() {
	var app;
	
	beforeEach(function() {
		jasmine.getFixtures().fixturesPath = '/src/test/fixtures'
		loadFixtures('mock-templates.html');
		$('body').append('<div id="rates">Loading...</div>');
		app = new App();
	});

	afterEach(function() {
		$('#rates').remove();
	});

	it("renders movies as they are added to the movies collection", function() {
		expect($("#rates").html()).not.toContain('a scanner darkly');
		app.movies.add(new app.Movie({title: 'a scanner darkly', author: 'ridley scott', stars: 100}));
		expect($("#rates").html()).toContain('a scanner darkly');
	});
});