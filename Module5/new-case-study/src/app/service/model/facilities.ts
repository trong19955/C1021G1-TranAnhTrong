export interface facilities {
// {
//   "serviceId": 1,
//   "serviceName": "Villa Beach Front",
//   "serviceArea": 25000,
//   "rentalCost": 1000000,
//   "maxPeople": 10,
//   "rentalType": {
//     "rentalTypeId": 3,
//     "rentalTypeName": "day"
//   },
//   "serviceType": {
//     "serviceTypeId": 1,
//     "serviceTypeName": "Villa"
//   },
//   "roomStandard": "vip",
//   "extraAmenity": "Có hồ bơi",
//   "poolArea": 500,
//   "levels": 4
// },
  serviceId? : string,
  serviceName?: string,
  serviceArea?: number,
  rentalCost?: number,
  maxPeople?: number,
  roomStandard?: string,
  extraAmenity?: string,
  poolArea?: number,
  levels?: number
}
