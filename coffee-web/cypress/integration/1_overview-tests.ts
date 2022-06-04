describe('Overview Tests', () => {
  beforeEach(() => {
    cy.visit('/'); // baseUrl
  });

  afterEach(() => {
    // cy.visit('/login');
  });

  // Note: This manipulates the real data. In 'real-live' we would set up a test-database and a production one.

  it('Check if all Elements are visible', () => {
    // detect the DOM element containing the text
    cy.contains('I need Coffee');
    cy.contains('Id');
    cy.contains('Blend Name');
    cy.contains('Price/Kg');
    cy.contains('Roast Degree');
    cy.contains('Average Rating');
    cy.contains('No.');
    cy.contains('More');
  });
  it('Navigate to Detail View', () => {
    // will fail if the first entry is deleted
    cy.contains('keyboard_arrow_right').first().click();
    cy.wait(3000);
    cy.location().should((loc) => {
      expect(loc.href).to.eq('http://localhost:4200/coffeemix/1');
    });
    cy.contains('Coffee Blend');
    cy.contains('Name');
    cy.contains('Price per Kg');
    cy.contains('Reviews');
    cy.contains('Main Data');
    cy.contains('Beans');
  });
  it('Navigate to New Coffee Mix Form', () => {
    cy.contains(' Add Coffee Blend ').click();
    cy.wait(3000);
    cy.contains('Add a new Coffee Blend');
    cy.url().should('includes', 'add');
  });
  it('Navigate to New Rating Form', () => {
    cy.contains('add_circle_outline').first().click();
    cy.wait(3000);
    cy.contains('Rating for a Cup of');
    cy.url().should('includes', '');
  });
  it('Navigate to About Page', () => {
    cy.contains('more_vert').first().click();
    cy.wait(3000);
    cy.contains('About').click();
    cy.contains('HOW TO');
    cy.url().should('includes', '');
  });
});
