cd frontend
npm run build

cp -r dist/* ../src/main/resources/static

cd ..

#mvn clean package