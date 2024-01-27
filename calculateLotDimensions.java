private void calculateLotDimensions(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));
		int rowCount = 0;
		int spotCount = 0;
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			if (!str.equals(SECTIONER)) {
            rowCount++;
            String[] spots = str.split(SEPARATOR);
            spotCount = Math.max(spotCount, spots.length);
        } else {
            break;
        }
			// WRITE YOUR CODE HERE!
		}
	
		this.numRows = rowCount;
		this.numSpotsPerRow = spotCount;

		this.lotDesign = new CarType[numRows][numSpotsPerRow];
		this.occupancy = new Car[numRows][numSpotsPerRow];

		scanner.close();
	}
