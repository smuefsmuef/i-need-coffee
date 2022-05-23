describe('Overview Tests', () => {

  beforeEach(() => {
    cy.visit('/'); // baseUrl
  });

  afterEach(() => {
    // cy.visit('/login');
  });

  it('Check if all Elements are visible', () => {
    // detect the DOM element containing the text
    cy.contains('Overview - ');
    cy.contains('Java Blend');
    cy.contains("Id");
    cy.contains("Blend Name");
    cy.contains("Price/Kg");
    cy.contains("Roast Degree");
    cy.contains('More');

    // detect all links
    cy.get('a').should('have.length', 5);
    // detect buttons
    cy.get('[id^=btn-link').should('have.length', 2);
  });

  it('Navigate to Detail View', () => {
    cy.get('a[href*="/coffeemix/"]').click();
    cy.wait(3000);
    cy.location().should((loc) => {
      expect(loc.href).to.eq('http://localhost:4200/coffeemix/1');
    });
    cy.contains('dd');
    cy.contains('d');
    cy.contains('dd');
  });
  it('Navigate to New Coffee Mix Form', () => {
    cy.get('a[href*="/add"]').click();
    cy.wait(3000);

    cy.contains('dsfsdf');
    cy.url().should('includes', 'add');
  });
});
