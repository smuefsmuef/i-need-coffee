describe('Coffee Mix Delete Tests', () => {
  it('Check how many Coffee Mixes there are', () => {
    cy.visit('/');
    cy.contains('This is a super long New Name for a Blend');
  });
  it('Navigate to Detail View', () => {
    cy.visit('/');
    cy.contains('keyboard_arrow_right').last().click();
    cy.wait(3000);
    cy.contains('New Name for a Blend');
  });
  it('Delete Blend', () => {
    cy.wait(2200);
    cy.contains('delete_outline').click();
  });
  it('Check if the  Blend is deleted', () => {
    cy.wait(1000);
    cy.contains('long New Name for a Blend').should('not.exist');
  });
});
