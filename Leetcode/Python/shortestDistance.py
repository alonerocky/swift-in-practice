def shortestDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        if word1 is None or word2 is None:
            return -1
        elif word1 == word2:
            return 0
        else:
            dict = {}
            for index, word in enumerate(words):
                if word in dict:
                    dict[word].append(index)
                else:
                    dict[word] = [index]
            
            index1 = dict[word1]
            index2 = dict[word2]
            i = 0
            j = 0
            distance = len(words) + 1
            while i < len(index1) and j < len(index2):
                distance = min(distance, abs(index1[i]- index2[j]))
                if index1[i] < index2[j]:
                    i += 1
                else:
                    j += 1
            
            return distance
