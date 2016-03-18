INSERT IGNORE INTO `Role` (`id`, `description`, `name`) VALUES
  (1, 'ROLE_ADMIN', 'Admin'),
  (2, 'ROLE_USER', 'Utilisateur');


  INSERT IGNORE INTO `Utilisateur` (`id`, `nom`, `password`, `role_id`) VALUES
  (1, 'hajar', 'aaa', 1),
  (2, 'sisi','aaa', 2);
