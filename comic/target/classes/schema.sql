DROP TABLE IF EXISTS comic_characters;
DROP TABLE IF EXISTS comics;
DROP TABLE IF EXISTS heroes;
DROP TABLE IF EXISTS villains;
DROP TABLE IF EXISTS publishers;

CREATE TABLE IF NOT EXISTS publisher (
  publisher_id INT AUTO_INCREMENT PRIMARY KEY,
  publisher_name VARCHAR(255),
  publisher_street VARCHAR(255),
  publisher_state VARCHAR(255),
  publisher_zip VARCHAR(10),
  publisher_phone VARCHAR(15),
  publisher_email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS hero (
  hero_id INT AUTO_INCREMENT PRIMARY KEY,
  publisher_id INT,
  hero_name VARCHAR(255),
  hero_secret_identity VARCHAR(255),
  hero_powers VARCHAR(255),
  FOREIGN KEY (publisher_id) REFERENCES publisher(publisher_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS villain (
  villain_id INT AUTO_INCREMENT PRIMARY KEY,
  publisher_id INT,
  villain_name VARCHAR(255),
  villain_secret_identity VARCHAR(255),
  villain_powers VARCHAR(255),
  FOREIGN KEY (publisher_id) REFERENCES publisher(publisher_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS comic (
  comic_id INT AUTO_INCREMENT PRIMARY KEY,
  publisher_id INT,
  comic_name VARCHAR(255),
  comic_original_price DECIMAL(10, 2),
  comic_current_value DECIMAL(10, 2),
  FOREIGN KEY (publisher_id) REFERENCES publisher(publisher_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS comic_characters (
  comic_characters_id INT AUTO_INCREMENT PRIMARY KEY,
  comic_id INT,
  hero_id INT,
  villain_id INT,
  FOREIGN KEY (comic_id) REFERENCES comic(comic_id),
  FOREIGN KEY (hero_id) REFERENCES hero(hero_id),
  FOREIGN KEY (villain_id) REFERENCES villain(villain_id) ON DELETE SET NULL
);
