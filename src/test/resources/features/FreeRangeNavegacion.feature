Feature: Navigation bar

  Scenario Outline: I can access the subpages through the navigation bar
    Given I navigate to www.freerangetesters.com
    When I go to <Section> using the navigation bar
    Examples:
      | Section   |
      | Cursos    |
      | Mentorías |
      | Talleres  |
      | Blog      |
      | Recursos  |