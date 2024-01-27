private void populateFromFile(String strFilename) throws Exception {
        try {
            Scanner scanner = new Scanner(new File(strFilename));
            int row = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(SECTIONER)) {
                    row = 0;
                    continue;
                }

                String[] spots = line.split(SEPARATOR);
                for (int col = 0; col < spots.length; col++) {
                    CarType carType = Util.getCarTypeByLabel(spots[col]);
                    this.lotDesign[row][col] = carType;
                }
                row++;
            }

            row = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(SEPARATOR);
                int rowIndex = Integer.parseInt(values[0]);
                int colIndex = Integer.parseInt(values[1]);
                CarType carType = Util.getCarTypeByLabel(values[2]);
                String plateNumber = values[3];

                if (rowIndex >= 0 && rowIndex < numRows && colIndex >= 0 && colIndex < numSpotsPerRow
                        && lotDesign[rowIndex][colIndex] != CarType.NA) {
                    Car car = new Car(carType, plateNumber);
                    this.occupancy[rowIndex][colIndex] = car;
                }
                row++;
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
