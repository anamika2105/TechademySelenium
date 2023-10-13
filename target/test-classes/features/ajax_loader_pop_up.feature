Feature:Verify AJAX LOADER pop-up functionality

  Scenario:Verify pop-up on AJAX LOADER page
  Given AJAX LOADER page
  When I click the "Click Me!" button
  Then pop should display
  And bowser should close