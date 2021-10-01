package io.quarkus.qe.messaging.infinispan.books;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(includeClasses = { Book.class }, schemaPackageName = "book_sample")
interface BookContextInitializer extends SerializationContextInitializer {
}
