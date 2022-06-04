const newName = 'This is a super long New Name for a Blend';
const newPrice = '1000';

describe('Coffee Mix Edit Tests', () => {
  it('Navigate to Detail View', () => {
    cy.visit('/');
    cy.contains('keyboard_arrow_right').click();
    cy.wait(3000);
    cy.contains('Main Data');
  });
  it('Return back to Overview View', () => {
    cy.get('button').first().click();
    cy.wait(3000);
    cy.contains('My Coffee Blend');
  });
  it('Navigate to Detail View', () => {
    cy.visit('/');
    cy.contains('keyboard_arrow_right').click();
    cy.wait(3000);
    cy.contains('Coffee Blend');
  });
  it('Change Blend Name', () => {
    cy.get('#name').click();
    cy.get('#namefield').clear();
    cy.get('#namefield').click().type(newName);
  });
  it('Submit Form possible', () => {
    cy.contains('UPDATE & BACK').click();
    cy.wait(3000);
  });
  it('Check if the New Blend is added', () => {
    cy.wait(1000);
    cy.contains(newName);
  });
  it('Navigate to Detail View', () => {
    cy.visit('/');
    cy.contains('keyboard_arrow_right').click();
    cy.wait(3000);
    cy.contains('Coffee Blend');
  });
  it('Change Blend Price', () => {
    cy.get('#price').click();
    cy.get('#pricefield').clear();
    cy.get('#pricefield').click().type(newPrice);
  });
  it('Submit Form possible', () => {
    cy.contains('UPDATE & BACK').click();
    cy.wait(3000);
  });
  it('Check if the New Blend is added', () => {
    cy.wait(1000);
    cy.contains(newPrice);
  });
  it('Submit empty Form not possible', () => {
    // not implemented atm
    // clear form, then check if button is disabled
    // cy.contains('UPDATE & BACK').should('have.class', 'mat-button-disabled');
  });
  // further tests would check all form inputs and check if there are reviews etc.
});
