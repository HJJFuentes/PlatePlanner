CREATE TABLE IF NOT EXISTS dairy (
  name TEXT PRIMARY KEY NOT NULL,
  price REAL DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `meats`
--

CREATE TABLE IF NOT EXISTS meats (
  name TEXT PRIMARY KEY NOT NULL,
  price REAL DEFAULT NULL,
  type TEXT DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `spices`
--

CREATE TABLE IF NOT EXISTS spices (
  name TEXT PRIMARY KEY NOT NULL,
  price REAL DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `vegetables`
--

CREATE TABLE IF NOT EXISTS vegetables (
  name TEXT PRIMARY KEY NOT NULL,
  price REAL NOT NULL,
  is_organic INTEGER DEFAULT 0
);

-- SQLite does not require the COMMIT statement for table creation