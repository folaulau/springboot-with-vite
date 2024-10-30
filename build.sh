cd frontend
npm run build

cp -r build/* ../src/main/resources/static

mvn clean package