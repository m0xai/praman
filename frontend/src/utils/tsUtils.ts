export const getEnumKeyByValue = (enumerated: any, value: string) => {
  return Object.keys(enumerated)[
    Object.values(enumerated).indexOf(value as typeof enumerated)
  ];
};
